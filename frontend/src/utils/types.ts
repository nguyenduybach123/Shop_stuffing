export interface Component {
    isFetching?: boolean
}

export interface Banner extends Component {
    title: string,
    description: string,
    background: string,
    image: string
}