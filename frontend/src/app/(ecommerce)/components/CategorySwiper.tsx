"use client"
import { Swiper, SwiperSlide } from "swiper/react";
import { CategoryCard } from "./CategoryCard";
import { Navigation, Pagination } from "swiper/modules";


export const CategorySwiper = () => {
  return (
    <div className='px-4 md:px-8 lg:px-16'>
        <h1 className='text-2xl mb-5'>Categories</h1>
        <Swiper
            pagination={{
                clickable: true,
              }}
      
              breakpoints={{
                '@0.00': {
                    slidesPerView: 2,
                    spaceBetween: 10,
                },
                768: {
                  slidesPerView: 4,
                  spaceBetween: 15,
                },
                1024: {
                  slidesPerView: 5,
                  spaceBetween: 20,
                },
              }}
              modules={[Navigation, Pagination]}
        >
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
            <SwiperSlide>
                <CategoryCard />
            </SwiperSlide>
        </Swiper>
    </div>
  )
}