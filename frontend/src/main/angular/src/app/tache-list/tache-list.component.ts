import { Colocation } from 'src/assets/models/rest';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-tache-list',
  templateUrl: './tache-list.component.html',
  styleUrls: ['./tache-list.component.css']
})
export class TacheListComponent implements OnInit {

  @Input() colocation:Colocation | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  getTachesByScope(scope:string,roomate:string){
    return this.colocation?.roomates
        .filter(elt => elt.name === roomate)[0]
            .taches.filter(elt=> elt.scope ===scope);
  }

}
