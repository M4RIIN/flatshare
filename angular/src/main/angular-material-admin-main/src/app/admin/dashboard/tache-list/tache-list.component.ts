import { Tache } from './../../../../assets/models/rest';
import { Colocation } from '../../../../assets/models/rest';
import { Subscription } from 'rxjs';
import { ColocationService } from '../../../services/colocation.service';
import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';

interface Place {
  imgSrc: string;
  name: string;
  description: string;
  charge: string;
  location: string;
}

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];


@Component({
  selector: 'app-tache-list',
  templateUrl: './tache-list.component.html',
  styleUrls: ['./tache-list.component.scss']
})
export class TacheListComponent implements OnInit,OnChanges {
  @Input() taches : Tache[] = [];
  @Input() title:string = "";
  @Input() color:string = "primary";
  displayedColumns: string[] = ['select', 'piece', 'libelle'];
  dataSource = new MatTableDataSource<Tache>();
  selection = new SelectionModel<Tache>(true, []);
  places: Array<Place> = [];
  nbrColocataires:number = 0;
  nbrTacheCommunes:number = 0;
  nbrTachePrivees:number = 0;
  colocation!:Colocation;
  constructor(private colocationService:ColocationService) {}

  
  ngOnInit() {

    // this.colocationService.getColocation().subscribe(c =>{
    //   this.nbrColocataires = c.roomates.length;
    //   this.nbrTacheCommunes = c.rooms.filter(piece => piece.scope === "COMMUNE").reduce((sum,current) => sum + current.task.length,0);
    //   this.nbrTachePrivees = c.rooms.filter(piece => piece.scope === "PRIVEE").reduce((sum,current) => sum + current.task.length,0);
    //   this.colocation = c;
    // })
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(changes && changes['taches']){
      this.dataSource = new MatTableDataSource<Tache>(this.taches);
    }
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Tache): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row['position'] + 1}`;
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

  getIconNameFromPieceName(pieceName:string):string{
    switch (pieceName) {
      case 'chambre':
        return 'king_bed';
      case 'salle de bain':
        return 'bathtub';
      case 'toilettes':
        return 'wc';
      case 'salon':
        return 'chair';
      case 'escalier':
        return 'stairs'
      case 'cuisine':
        return 'kitchen'
      default:
        return '';
    }
  }
}
