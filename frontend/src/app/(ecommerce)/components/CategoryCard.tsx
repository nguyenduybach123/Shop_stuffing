import Image from 'next/image'
import Link from 'next/link'
import React from 'react'

export const CategoryCard = () => {
  return (
    <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
        <div className='relative bg-slate-100 w-full h-64'>
            <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover rounded-md' />
        </div>
        <h1 className='mt-4 text-center font-light text-clip tracking-wide'>Category Name</h1>
    </Link>
  )
}
