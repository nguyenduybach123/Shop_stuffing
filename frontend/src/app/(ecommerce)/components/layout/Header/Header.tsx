"use client"
import Link from 'next/link';

import SearchBar from '../../SearchBar';
import { NavbarMenuIcons } from './NavbarMenuIcons';
import { NavbarMenu } from './NavbarMenu';
import React from 'react';

const Header = () => {

  React.useEffect(() => {
    function handleScroll() {
      const header = document.getElementById('header');

      if (header === null) {
        return;
      }

      if (window.scrollY > 100) {
        header.classList.remove('relative');
        header.classList.add('stickey');
      } else {
        header.classList.remove('stickey');
        header.classList.add('relative');
      }
    }

    window.addEventListener('scroll', handleScroll);

    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  return (
    <div id="header" className="w-full bg-white h-20 px-4 md:px-8 lg:px-16 z-20">
      {/* MOBILE */}
      <div className='h-full flex items-center justify-between md:hidden'>
        <Link href='/'>
          <div className='text-2xl tracking-wide'>
            CORN
          </div>
        </Link>
        <NavbarMenu />
      </div>
      {/* BIGGER SCREENS */}
      <div className='hidden md:flex items-center justify-between gap-8 h-full'>
        {/* LEFT */}
        <div className='w-1/3 xl:w-1/2 flex items-center gap-12'>
          <Link href='/' className='flex items-center gap-3'>
            <div className='text-2xl font-semibold text-slate-500'>CORN</div>
          </Link>
          <div className='hidden xl:flex gap-4'>
            <Link href='/'>Home</Link>
            <Link href='/'>Shop</Link>
            <Link href='/'>Deals</Link>
            <Link href='/'>About</Link>
            <Link href='/'>Contact</Link>
          </div>
        </div> 
        {/* RIGHT */}
        <div className='w-2/3 flex items-center justify-between gap-8'>
          <SearchBar />
          <NavbarMenuIcons />
        </div>
      </div>
    </div>
  )
}
 
export default Header;