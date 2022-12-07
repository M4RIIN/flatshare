
export class Colocation{
    rooms!: Room[];
    id!:string;
    roomates!: Roomate[];
    name!:string;
}

export class Room{
    type!: string;
    scope!: string;
    task: string[] = [];
}

export class Roomate{
    name!: string;
    taches: Tache[] = [];
}

export class Tache{
  nom!:string;
  scope!:string;
  piece!:string;
}
