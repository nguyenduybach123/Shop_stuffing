"use client"

import { useQuery } from "@tanstack/react-query";
import { ChangeEvent, Dispatch, SetStateAction, useState } from "react";
import { z } from "zod";

enum MODE  {
    LOGIN = "LOGIN",
    REGISTER = "REGISTER",
    RESET_PASSWORD = "RESET_PASSWORD",
    EMAIL_VERIFICATION = "EMAIL_VERIFICATION"
}

const RegisterSchema = z.object({
    username: z.string().trim().min(2).max(256),
    email: z.string().email().optional(),
    password: z.string().min(6).max(100),
    confirmPassword: z.string().min(6).max(100)
})
.strict()
.superRefine(({ confirmPassword, password }, ctx) => {
    if (confirmPassword !== password) {
        ctx.addIssue({
            code: 'custom',
            message: 'Mật khẩu không khớp',
            path: ['confirmPassword']
        });
    }
});

const LoginSchema = z.object({
    username: z.string().trim().min(6,{message: "Must be at least 6 characters"}).max(256,{message: "Must have a maximum of 256 characters"}),
    password: z.string().min(6,{message: "Must be at least 6 characters"}).max(100,{message: "Must have a maximum of 100 characters"}),
})
.strict();

type UserError = {
    username?: string,
    email?: string,
    password?: string
} 

export const LoginPage = () => {
  
  const [mode, setMode] = useState(MODE.LOGIN);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailCode, setEmailCode] = useState("");
  const [error, setError] = useState<UserError>({});
  const [message, setMessage] = useState("");

  const isLoading = true;

  const formTitle =
    mode === MODE.LOGIN
      ? "Log in"
      : mode === MODE.REGISTER
      ? "Register"
      : mode === MODE.RESET_PASSWORD
      ? "Reset Your Password"
      : "Verify Your Email";

  const buttonTitle =
    mode === MODE.LOGIN
      ? "Login"
      : mode === MODE.REGISTER
      ? "Register"
      : mode === MODE.RESET_PASSWORD
      ? "Reset"
      : "Verify";

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
        let response;

        switch(mode) {
            case MODE.LOGIN:
                response = await handleLogin();
                break;
            default:
                break;
        }
    }
    catch(err) {
        console.log(err);
    }
  }

  const handleLogin = async () => {
    const userLogin = {
        username,
        password
    };

    //Validate data user login
    const result = LoginSchema.safeParse(userLogin);
    if(!result.success) {
        result.error.issues.map((issue) => {
            setError(prev => ({...prev, [issue.path[0]]: issue.message}));
        })
    }

    //Login user

  }

  const handleOnChangeInput = (e: ChangeEvent<HTMLInputElement>, onChangeFunc: Dispatch<SetStateAction<any>>) => {
    if(error.username != "" || error.password != "" || error.email != "") {
        setError(prev => ({...prev, [e.target.name]: ""}));
    }
    onChangeFunc(e.target.value);
  }

  return (
        <div className="h-[calc(100vh-80px)] px-4 md:px-8 lg:px-16 xl:px-32 2xl:px-64 flex items-center justify-center">
            <form className="flex flex-col gap-8" onSubmit={handleSubmit}>
                <h1 className="text-2xl font-semibold">{formTitle}</h1>
                {mode === MODE.LOGIN || mode === MODE.REGISTER ? (
                    <div className="flex flex-col gap-2">
                        <label className="text-sm text-gray-700">Username</label>
                        <input
                            type="text"
                            name="username"
                            placeholder="Username"
                            className="ring-2 ring-gray-300 rounded-md p-4"
                            onChange={(e) => handleOnChangeInput(e,setUsername)}
                        />
                        {error.username && <span className='font-medium text-red-400'>{error.username}</span>}
                    </div>
                ) : null}
                {mode === MODE.RESET_PASSWORD ? (
                    <div className="flex flex-col gap-2">
                        <label className="text-sm text-gray-700">Verification Code</label>
                        <input
                            type="text"
                            name="emailCode"
                            placeholder="Code"
                            className="ring-2 ring-gray-300 rounded-md p-4"
                            onChange={(e) => handleOnChangeInput(e,setEmailCode)}
                        />
                    </div>
                ) : mode === MODE.REGISTER ? (
                    <div className="flex flex-col gap-2">
                        <label className="text-sm text-gray-700">E-mail</label>
                        <input
                        type="email"
                        name="email"
                        placeholder="john@gmail.com"
                        className="ring-2 ring-gray-300 rounded-md p-4"
                        onChange={(e) => handleOnChangeInput(e,setEmail)}
                        />
                        {error.email && <span className='font-medium text-red-400'>{error.email}</span>}
                    </div>
                ): null}
                {mode === MODE.LOGIN || mode === MODE.REGISTER ? (
                    <div className="flex flex-col gap-2">
                        <label className="text-sm text-gray-700">Password</label>
                        <input
                            type="password"
                            name="password"
                            placeholder="Enter your password"
                            className="ring-2 ring-gray-300 rounded-md p-4"
                            onChange={(e) => handleOnChangeInput(e,setPassword)}
                        />
                        {error.password && <span className='font-medium text-red-400'>{error.password}</span>}
                    </div>
                ) : null}
                {mode === MODE.LOGIN && (
                    <div
                    className="text-sm underline cursor-pointer"
                    onClick={() => setMode(MODE.RESET_PASSWORD)}
                    >
                        Forgot Password?
                    </div>
                )}
                <button
                    className="bg-[#F35C7A] text-white p-2 rounded-md disabled:bg-pink-200 disabled:cursor-not-allowed"
                    disabled={isLoading}
                >
                    {isLoading ? "Loading..." : buttonTitle}
                </button>
                {mode === MODE.LOGIN && (
                    <div
                    className="text-sm underline cursor-pointer"
                    onClick={() => setMode(MODE.REGISTER)}
                    >
                        {"Don't"} have an account?
                    </div>
                )}
                {mode === MODE.REGISTER && (
                    <div
                    className="text-sm underline cursor-pointer"
                    onClick={() => setMode(MODE.LOGIN)}
                    >
                        Have and account?
                    </div>
                )}
                {mode === MODE.RESET_PASSWORD && (
                    <div
                    className="text-sm underline cursor-pointer"
                    onClick={() => setMode(MODE.LOGIN)}
                    >
                        Go back to Login
                    </div>
                )}
                {message && <div className="text-green-600 text-sm">{message}</div>}
            </form>
        </div>
    );
}

export default LoginPage;