import cn from "classnames"

type Icon = {
    width?: number,
    height?: number,
    className?: string,
    onClick?: () => void
}

export const MenuIcon = ({width = 20, height = 20, className, onClick}: Icon ) => {
  return (
    <svg width={width} height={height} className={cn("h-8 w-8 text-slate-500",className)}  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  strokeWidth="2"  strokeLinecap="round"  strokeLinejoin="round" onClick={onClick}>  
        <line x1="3" y1="12" x2="21" y2="12" />  
            <line x1="3" y1="6" x2="21" y2="6" />  
        <line x1="3" y1="18" x2="21" y2="18" />
    </svg>
  )
}

export const SearchIcon = ({width = 20, height = 20, className, onClick}: Icon ) => {
  return (
    <svg className={cn("h-8 w-8 text-slate-500",className)}  width={width} height={height} viewBox="0 0 24 24" strokeWidth="2" stroke="currentColor" fill="none" strokeLinecap="round" strokeLinejoin="round" onClick={onClick}>  
      <path stroke="none" d="M0 0h24v24H0z"/>  
      <circle cx="10" cy="10" r="7" />  
      <line x1="21" y1="21" x2="15" y2="15" />
    </svg>
  )
} 

export const UserCircleIcon = ({width = 20, height = 20, className, onClick}: Icon ) => {
  return (
    <svg className={cn("h-8 w-8 text-slate-500", className)} width={width} height={height} fill="none" viewBox="0 0 24 24" stroke="currentColor" onClick={onClick}>
      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
    </svg>
  )
}

export const BellIcon = ({width = 20, height = 20, className, onClick}: Icon ) => {
  return (
    <svg className={cn("h-8 w-8 text-slate-500",className)}  width={width} height={height} viewBox="0 0 24 24" strokeWidth="2" stroke="currentColor" fill="none" strokeLinecap="round" strokeLinejoin="round" onClick={onClick}>  
      <path stroke="none" d="M0 0h24v24H0z"/>  
        <path d="M10 5a2 2 0 0 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6" />  
      <path d="M9 17v1a3 3 0 0 0 6 0v-1" />
    </svg>
  )
} 

export const CartIcon = ({width = 20, height = 20, className, onClick}: Icon ) => {
  return (
    <svg className={cn("h-8 w-8 text-slate-500",className)} width={width} height={height} viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  strokeWidth="2"  strokeLinecap="round"  strokeLinejoin="round" onClick={onClick}>  
      <circle cx="9" cy="21" r="1" />  <circle cx="20" cy="21" r="1" />  
      <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6" />
    </svg>
  )
} 
