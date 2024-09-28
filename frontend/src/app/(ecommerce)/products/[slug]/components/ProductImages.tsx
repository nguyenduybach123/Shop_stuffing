"use client"

import Image from "next/image";
import { useState } from "react";

const images = [
  {
    id: 1,
    url: "https://images.pexels.com/photos/19346705/pexels-photo-19346705/free-photo-of-toa-nha-t-ng-ngoai-v-t-nuoi.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
  },
  {
    id: 2,
    url: "https://images.pexels.com/photos/19037600/pexels-photo-19037600/free-photo-of-v-t-nuoi-d-th-ng-ng-i-cac-c-a-s.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
  },
  {
    id: 3,
    url: "https://images.pexels.com/photos/15989106/pexels-photo-15989106/free-photo-of-d-ng-ph-thu-v-t-d-ng-v-t-con-v-t.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
  },
  {
    id: 4,
    url: "https://images.pexels.com/photos/19346705/pexels-photo-19346705/free-photo-of-toa-nha-t-ng-ngoai-v-t-nuoi.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
  }
]

export const ProductImages = () => {
    const [index, setIndex] = useState(0)

  return (
    <div className=''>
        <div className='h-[500px] relative'>
          <Image src={images[index].url} alt=''
                      fill sizes='30vw'
                      className='object-cover rounded-md'
          />
        </div>  
        <div className='flex justify-between gap-4 mt-8'>
          {
            images.map((image,idx) => (
              <div key={image.id} className='w-1/4 h-32 relative gap-4 mt-8 cursor-pointer' onClick={() => setIndex(idx)}>
                <Image src={image.url} alt=''
                        fill sizes='30vw'
                        className='object-cover rounded-md'
                />
              </div>
            ))
          }
        </div>   
    </div>
  )
}
