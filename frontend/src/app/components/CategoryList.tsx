import Image from "next/image";
import Link from "next/link";


const CategoryList = () => {
  return (
    <div className='px-4 overflow-x-scroll scrollbar-hide'>
        <div className='flex gap-4 md:gap-8'>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
            {/* CATEGORY */}
            <Link href='/' className='flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6'>
                <div className='relative bg-slate-100 w-full h-96'>
                    <Image src='https://images.pexels.com/photos/26861260/pexels-photo-26861260/free-photo-of-nh-ng-ng-i-d-ng-ph-t-ng-v-n.jpeg?auto=compress&cs=tinysrgb&w=300&lazy=load' alt='' fill sizes='20vw' className='object-cover' />
                </div>
                <h1 className='mt-8 font-light text-clip tracking-wide'>Category Name</h1>
            </Link>
        </div>
    </div>
  )
}

export default CategoryList;