"use client"

import { useState } from "react";
import { BellIcon, CartIcon, UserCircleIcon } from "./Icon";
import Link from "next/link";
import { useRouter } from "next/navigation";
import CartModal from "./CartModal";

const NavIcons = () => {

  const router = useRouter();
  const [isProfileOpen, setIsProfileOpen] = useState(false);
  const [isCartOpen, setIsCartOpen] = useState(false);
  
  //TEMPORARY
  const isLoggedIn = () => {
    return true;
  }

  const handleProfile = () => {
    if(!isLoggedIn()) {
        router.push("/login");
    }
    setIsProfileOpen(prev => !prev);
  }

  console.log(isProfileOpen);

  return (
    <div className='flex items-center gap-4 xl:gap-6 relative'>
        <UserCircleIcon width={22} height={22} className='cursor-pointer' onClick={handleProfile} />
        {
            isProfileOpen &&
                <div className='absolute p-4 rounded-md top-12 left-0 bg-white text-sm shadow-[0_3px_10px_rgb(0,0,0,0.2)] z-20'>
                    <Link href='/'>Profile</Link>
                    <div className='mt-2 cursor-pointer'>Logout</div>
                </div>
        }
        <BellIcon width={22} height={22} className='cursor-pointer' />
        <div className='relative cursor-pointer'>
            <CartIcon width={22} height={22} className='cursor-pointer' onClick={() => setIsCartOpen(prev => !prev)} />
            <div className='absolute -top-4 -right-4 w-6 h-6 bg-[#F35C7A] rounded-full text-sm text-white flex items-center justify-center'>2</div>
        </div>
        { isCartOpen && <CartModal /> }
    </div>
  )
}

export default NavIcons;