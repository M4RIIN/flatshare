import { Colocation } from './../../../../assets/models/rest';
import { Subscription } from 'rxjs';
import { ColocationService } from './../../../services/colocation.service';
import { Component, OnInit } from '@angular/core';

interface Place {
  imgSrc: string;
  name: string;
  description: string;
  charge: string;
  location: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  places: Array<Place> = [];
  nbrColocataires:number = 0;
  nbrTacheCommunes:number = 0;
  nbrTachePrivees:number = 0;
  colocation!:Colocation;
  constructor(private colocationService:ColocationService) {}
  
  ngOnInit() {
    this.colocationService.getColocation().subscribe(c =>{
      this.nbrColocataires = c.roomates.length;
      this.nbrTacheCommunes = c.rooms.filter(piece => piece.scope === "COMMUNE").reduce((sum,current) => sum + current.task.length,0);
      this.nbrTachePrivees = c.rooms.filter(piece => piece.scope === "PRIVEE").reduce((sum,current) => sum + current.task.length,0);
      this.colocation = c;
    })
  }

  getNextMonday() {
    const dateCopy = new Date();
  
    const nextMonday = new Date(
      dateCopy.setDate(
        dateCopy.getDate() + ((7 - dateCopy.getDay() + 1) % 7 || 7),
      ),
    );
  
    return nextMonday;
  }

  getTachesByScope(scope:string,roomate:string){
    return this.colocation?.roomates
        .filter(elt => elt.name === roomate)[0]
            .taches.filter(elt=> elt.scope ===scope);
  }
}
