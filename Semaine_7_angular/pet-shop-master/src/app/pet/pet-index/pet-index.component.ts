import { Component, OnInit } from '@angular/core';
import { PetService } from '../pet.service';

@Component({
  selector: 'app-pet-index',
  templateUrl: './pet-index.component.html',
  styleUrls: ['./pet-index.component.scss']
})
export class PetIndexComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
