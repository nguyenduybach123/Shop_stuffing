"use client"

import { Swiper, SwiperSlide } from "swiper/react"
import { Pagination } from "swiper/modules"
import { Banner } from "./Banner"

export const BannerSwiper = () => {

  return (
    <Swiper
      spaceBetween={0}
      slidesPerView={1}
      pagination={{
        clickable: true,
      }}
      modules={[Pagination]}
    >
      <SwiperSlide className="px-4 md:px-8 lg:px-16">
        <Banner title="Spring" description="Spring" background="" image="" />
      </SwiperSlide>
      <SwiperSlide className="px-4 md:px-8 lg:px-16">
        <Banner title="Spring" description="Spring" background="" image="" />
      </SwiperSlide>
      <SwiperSlide className="px-4 md:px-8 lg:px-16">
        <Banner title="Spring" description="Spring" background="" image="" />
      </SwiperSlide>
    </Swiper>
  )
}