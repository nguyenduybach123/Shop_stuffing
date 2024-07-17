"use client"

import cn from "classnames";
import Image from "next/image";
import Link from "next/link";
import { useEffect, useState } from "react";

const slides = [
    {
        id: 1,
        title: "Summer Sale Collections",
        description: "Sale ! Up to 50% off!",
        img: "https://images.pexels.com/photos/19349789/pexels-photo-19349789/free-photo-of-nha-v-d-th-dintle-x-olerato-motshebe.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
        url: "/",
        bg: "bg-gradient-to-r from-blue-50 to-pink-50"
    },
    {
        id: 2,
        title: "Winter Sale Collections",
        description: "Sale ! Up to 50% off!",
        img: "https://images.pexels.com/photos/26690666/pexels-photo-26690666/free-photo-of-l-nh-tuy-t-phong-c-nh-mua-dong.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
        url: "/",
        bg: "bg-gradient-to-r from-blue-50 to-blue-50"
    },
    {
        id: 3,
        title: "Spring Sale Collections",
        description: "Sale ! Up to 50% off!",
        img: "https://images.pexels.com/photos/20632485/pexels-photo-20632485/free-photo-of-dan-ong-mo-hinh-mu-d-ng.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load",
        url: "/",
        bg: "bg-gradient-to-r from-blue-50 to-yellow-50"
    },
]

const Slider = () => {
  
  const [current, setCurrent] = useState(0);
  
//   useEffect(() => {
//     const interval = setInterval(() => {
//         setCurrent(prev => (prev === slides.length - 1 ? 0 : prev + 1));
//     }, 3000);

//     return () => clearInterval(interval);
//   },[])

  return (
    <div className='h-[calc(100vh-80px)] overflow-hidden'>
        <div className='w-max h-full flex transition-all ease-in-out duration-1000'
             style={{transform: `translateX(-${current * 100}vw)`}}
        >
            {
                slides.map(slide => (
                    <div key={slide.id} className={cn(slide.bg, 'w-screen h-full flex flex-col gap-16 xl:flex-row')}>
                        {/* TEXT CONTAINER */}
                        <div className='h-1/2 xl:w-1/2 xl:h-full flex flex-col items-center justify-center gap-8 2xl:gap-12 text-center'>
                            <h2 className='text-xl lg:text-3xl 2xl:text-5xl'>{slide.description}</h2>
                            <h1 className='text-5xl lg:text-6xl 2xl:text-8xl font-semibold'>{slide.title}</h1>
                            <Link href={slide.url}>
                                <button className='rounded-md bg-black text-white py-3 px-4'>SHOP NOW</button>
                            </Link>
                        </div>
                        {/* IMAGE CONTAINER */}
                        <div className='h-1/2 xl:w-1/2 xl:h-full relative'>
                            <Image src={slide.img} alt='' fill sizes='100%' className='object-cover' />
                        </div>
                    </div>
                ))
            }
        </div>
        <div className='absolute m-auto left-1/2 bottom-8 flex gap-4'>
            {
                slides.map((slide, index) => (
                    <div key={slide.id} className={cn('w-3 h-3 rounded-full ring-1 ring-gray-600 cursor-pointer flex items-center justify-center',{'scale-150': current === index})} onClick={() => setCurrent(index)}>
                        {
                            current === index &&
                                <div className='w-[6px] h-[6px] bg-gray-600 rounded-full'></div>
                        }
                    </div>
                ))
            }
        </div>
    </div>
  )
}

export default Slider;