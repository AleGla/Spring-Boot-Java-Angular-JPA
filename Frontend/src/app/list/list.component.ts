import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  private listOfPeople = [];
  private json: object;
  constructor(private service: ServiceService, private router: Router) { }

  ngOnInit() {
    this.getList();
  }

  getList(){
    this.service.getAllPeople().subscribe(response =>  {      
      this.listOfPeople = response
      console.log("Response List of Persons => " + this.listOfPeople);
    })
  }


  updatePerson(id: number){
    console.log(id);
    this.router.navigate(['toList/toUpdate', {id: id}]);
    window.scrollTo(0, 0);
  }


  deletePerson(person: object){
    this.deletePersonService(person);
    location.reload();
  }


  deletePersonService(person: object){   
    this.service.deletePerson(person).subscribe(response => {
        console.log("Response => ", response);
    })
  }


  

  

  






}
