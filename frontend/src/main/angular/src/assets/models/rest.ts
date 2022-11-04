
export class Colocation{
    rooms!: Room[];
    id!:string;
    roomates!: Roomate[];
}

export class Room{
    type!: string;
    scope!: string;
    task: string[] = [];
}

export class Roomate{
    name!: string;
    taches: string[] = [];
}