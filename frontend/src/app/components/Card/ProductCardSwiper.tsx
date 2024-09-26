"use client"

import React from 'react'
import { Autoplay, Navigation, Pagination } from 'swiper/modules'
import { Swiper, SwiperSlide } from 'swiper/react'
import { ProductCard } from './ProductCard';

const MAXIMUM_CARD_VIEW = 12;

export const ProductCardSwiper = () => {
  return (
    <div>
      <h3 className="font-semibold text-lg mb-3">Featured Products :</h3>
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

        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        modules={[Autoplay,Pagination,Navigation]}
      >
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
        <SwiperSlide>
          <ProductCard />
        </SwiperSlide>
      </Swiper>
    </div>
  )
}
