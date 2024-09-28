import React from 'react'
import Link from 'next/link'
import Image from 'next/image'
import cn from 'classnames'

import { Banner as BannerType} from '@/utils/types'

export const Banner = ({title, description, background, image, isFetching = false}: BannerType) => {
  return (
    <div className={cn('w-full h-[30rem] flex flex-col gap-16 xl:flex-row rounded-t-md rounded-bl-md bg-cover bg-center bg-no-repeat')} style={{background: 'url(https://images.pexels.com/photos/5124869/pexels-photo-5124869.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load)'}}>
        {/* TEXT CONTAINER */}
        <div className='h-1/2 xl:w-1/2 xl:h-full flex flex-col items-center justify-center gap-8 2xl:gap-12 text-center'>
            <h2 className='text-xl lg:text-3xl 2xl:text-5xl'>{description}</h2>
            <h1 className='text-5xl lg:text-6xl 2xl:text-8xl font-semibold'>{title}</h1>
            <Link href='/'>
                <button className='rounded-md bg-black text-white py-3 px-4'>SHOP NOW</button>
            </Link>
        </div>
        {/* IMAGE CONTAINER */}
        <div className='h-1/2 xl:w-1/2 xl:h-full relative'>
            <Image src={'https://images.pexels.com/photos/28124787/pexels-photo-28124787/free-photo-of-th-i-trang-dan-ba-d-cu-chan-dung.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load'} alt='' fill sizes="100%" className='object-cover  xl:rounded-r-md' />
        </div>
    </div>
  )
} 
