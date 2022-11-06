import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColocataireListComponent } from './colocataire-list.component';

describe('ColocataireListComponent', () => {
  let component: ColocataireListComponent;
  let fixture: ComponentFixture<ColocataireListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColocataireListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ColocataireListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
