"use client"
import { useState } from "react";
import Link from "next/link";

import { BellIcon, CartIcon, UserCircleIcon } from "../../../../components/Icon";
import { useRouter } from "next/navigation";
import CartModal from "../../CartModal";

export const NavbarMenuIcons = () => {

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

  return (
    <div className='flex items-center gap-4 xl:gap-6 relative'>
        <div className='relative'>
          <UserCircleIcon width={22} height={22} className='cursor-pointer' onClick={handleProfile} />
          {
              isProfileOpen &&
                  <div className='absolute rounded-md top-12 right-0 bg-white text-sm shadow-[0_3px_10px_rgb(0,0,0,0.2)] z-20'>
                      <div className='text-sm font-medium text-center hover:bg-slate-300 px-5 py-2 rounded-sm'>
                        <Link href='/'>Login</Link>
                      </div>
                      <div className='text-sm font-medium text-center hover:bg-slate-300 px-5 py-2 rounded-sm'>
                        <Link href='/'>Register</Link>
                      </div>
                  </div>
          }
        </div>
        <BellIcon width={22} height={22} className='cursor-pointer' />
        <div className='relative cursor-pointer'>
            <CartIcon width={22} height={22} className='cursor-pointer' onClick={() => setIsCartOpen(prev => !prev)} />
            <div className='absolute -top-4 -right-4 w-6 h-6 bg-[#F35C7A] rounded-full text-sm text-white flex items-center justify-center'>2</div>
        </div>
        { isCartOpen && <CartModal /> }
    </div>
  )
}