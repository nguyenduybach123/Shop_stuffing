import Image from 'next/image'
import Link from 'next/link'
import React from 'react'

export const ProductCard = () => {
  return (
    <Link href='/' className='w-full min-w-52 flex flex-col gap-4 after:hover:block '>
        <div className='relative w-full h-72 group/view after:content-[""] after:absolute after:top-0 after:right-0 after:bottom-0 after:left-0 hover:after:bg-black/50 after:rounded-md after:transition after:ease-in-out after:duration-300'>
            <Image src='https://images.pexels.com/photos/5326566/pexels-photo-5326566.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='25vw' className='absolute object-cover rounded-md z-10 hover:opacity-0 transition-opacity easy duration-500' />
            <Image src='https://images.pexels.com/photos/24516444/pexels-photo-24516444/free-photo-of-mon-an-dia-g-b-a-t-i.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load' alt='' fill sizes='25vw' className='absolute object-cover rounded-md' />
            <div className="w-full absolute bottom-0 left-0 hidden group-hover/view:flex text-center text-white font-semibold transition-all duration-300 z-10">
              <div className="bg-[#F35C7A] px-2 py-3 flex-1">Buy now</div>
              <div className="bg-green-500 px-2 py-3 flex-1">Add To Cart</div>
            </div>
        </div>
        <div className='flex justify-between'>
            <span className='font-medium'>Product Name</span>
            <span className='font-semibold'>$49</span>
        </div>
        <div className='text-sm text-gray-500'>My description</div>
    </Link>
  )
}
