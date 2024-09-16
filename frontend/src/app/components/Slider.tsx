"use client"

import { useQuery } from "@tanstack/react-query";
import cn from "classnames";
import Image from "next/image";
import Link from "next/link";
import { useState } from "react";
import http, { HttpResponse } from "../utils/http";

type Slider = {
    id: string,
    title: string,
    description: string,
    image: string,
    background: string
}

const Slider = () => {
    
  const {data, isLoading} = useQuery({
    queryKey: ['discount'],
    queryFn: () => http.get<HttpResponse<Slider[]>>("/discount")
  });
  
  const slides = data?.data?.data || [];

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
                slides.map((slide:Slider) => (
                    <div key={slide.id} className={cn(slide.background,'w-screen h-full flex flex-col gap-16 xl:flex-row')}>
                        {/* TEXT CONTAINER */}
                        <div className='h-1/2 xl:w-1/2 xl:h-full flex flex-col items-center justify-center gap-8 2xl:gap-12 text-center'>
                            <h2 className='text-xl lg:text-3xl 2xl:text-5xl'>{slide.description}</h2>
                            <h1 className='text-5xl lg:text-6xl 2xl:text-8xl font-semibold'>{slide.title}</h1>
                            <Link href='/'>
                                <button className='rounded-md bg-black text-white py-3 px-4'>SHOP NOW</button>
                            </Link>
                        </div>
                        {/* IMAGE CONTAINER */}
                        <div className='h-1/2 xl:w-1/2 xl:h-full relative'>
                            <Image src={slide.image} alt='' fill sizes="100%" className='object-cover' />
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