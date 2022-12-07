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
  constructor(public  colocationService:ColocationService) {}
  
  ngOnInit() {
    this.colocationService.getColocation().subscribe(c =>{
      this.colocation = c;
      this.nbrColocataires = c.roomates.length;
      this.nbrTacheCommunes = this.getTachesByScope('COMMUNE',this.colocationService.userConnected).length;
      this.nbrTachePrivees = this.getTachesByScope('PRIVEE',this.colocationService.userConnected).length;
    })
  }

  getNextMonday():Date {
    const dateCopy = new Date();
    dateCopy.setHours(12,0)
    const nextMonday = new Date(
      dateCopy.setDate(
        dateCopy.getDate() + ((7 - dateCopy.getDay() + 1) % 7 || 7),
      ),
    );
  
    return nextMonday;
  }
  getNow():Date{
    return new Date();
  }
  abs(value){
    return Math.abs(value);
  }

  getTachesByScope(scope:string,roomate:string){
    return this.colocation?.roomates
        .filter(elt => elt.name === roomate)[0]
            .taches.filter(elt=> elt.scope ===scope);
  }
}
