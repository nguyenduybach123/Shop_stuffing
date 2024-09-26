import { ProductCardSwiper } from "../components/Card/ProductCardSwiper";
import { BannerSwiper } from "./components/BannerSwiper";
import { CategorySwiper } from "./components/CategorySwiper";

export default function Home() {
  return (
    <main>
      <BannerSwiper />
      <div className="mt-24 px-4 md:px-8 lg:px-16">
        <ProductCardSwiper />
      </div>
      <div className='mt-24'>
        <CategorySwiper />
      </div>
      <div className='mt-24 px-4 md:px-8 lg:px-16'>
        <ProductCardSwiper />
      </div>
    </main>
  );
}

