
const Filter = () => {
  return (
    <div className='mt-12 flex justify-between'>
        <div className='flex gap-6 flex-wrap'>
            <select name='type' className='py-2 px-4 rounded-2xl text-xs font-medium bg-[#EBEDED]'>
                <option>Type</option>
                <option value='physical'>Physical</option>
                <option value='digital'>Digital</option>
            </select>
            <input type='text' name='min' placeholder='min price' className='text-xs rounded-2xl pl-2 w-24 ring-1 ring-gray-400' />
            <input type='text' name='max' placeholder='max price' className='text-xs rounded-2xl pl-2 w-24 ring-1 ring-gray-400' />
            <select name='size' className='py-2 px-4 rounded-2xl text-xs font-medium bg-[#EBEDED]'>
                <option>Size</option>
            </select>
            <select name='color' className='py-2 px-4 rounded-2xl text-xs font-medium bg-[#EBEDED]'>
                <option>Color</option>
            </select>
            <select name='ribbon' className='py-2 px-4 rounded-2xl text-xs font-medium bg-[#EBEDED]'>
                <option>Category</option>
                <option>New Arrival</option>
                <option>Popular</option>
            </select>
            <select name='ribbon' className='py-2 px-4 rounded-2xl text-xs font-medium bg-[#EBEDED]'>
                <option>All Filters</option>
            </select>
        </div>
        <div className=''>
            <select className='py-2 px-4 rounded-2xl text-xs font-medium bg-white ring-1 ring-gray-400'>
                <option>Sort By</option>
                <option value=''>Price (low to high)</option>
                <option value=''>Price (high to low)</option>
                <option value=''>Newest</option>
                <option value=''>Oldest</option>
            </select>
        </div>
    </div>
  )
}

export default Filter;