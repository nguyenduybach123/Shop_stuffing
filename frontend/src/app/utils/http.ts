import axios, { AxiosInstance } from "axios";

type Error = {
    message: string
}

export type HttpResponse<T> = {
    status: string,
    error: Error,
    data: T
}

class Http {
    instance: AxiosInstance;

    constructor() {
        this.instance = axios.create({
            baseURL: "http://localhost:8080",
            timeout: 10000,
            headers: {
                "Content-Type": "application/json"
            }
        });
    }
}

const http = new Http().instance;

export default http;