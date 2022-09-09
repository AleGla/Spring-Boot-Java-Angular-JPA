import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  
  @ViewChild('nationality') nationalitySelected!: ElementRef;

  private listOfPeople : any
  private listNationality = [];  
  private json: object;
  private search: boolean;
  constructor(private service: ServiceService, private router: Router, private fb: FormBuilder) { }

  
  ngOnInit() {

    this.getList();
    
  }

  getList(){
    
    this.service.getAllPeople().subscribe(response =>  {      
      this.listOfPeople = response      
      this.listNationality = [];
      this.listNationality.push("All");
      this.listOfPeople.forEach((values) => {
          if(!this.listNationality.includes(values.nationality)) this.listNationality.push(values.nationality);
      })
      if(this.nationalitySelected.nativeElement.value !== "" && !(this.search)){
        console.log("SECOND")
        this.onSelected();
      }else{
        this.search = false;
      }        
    }
        ) 
      
  }


  updatePerson(id: number){
    console.log(id);
    this.router.navigate(['toUpdate', {id: id}]);
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


  setOrderMoneyLowToHigh(){
    if(this.nationalitySelected.nativeElement.value === "All"){
    this.service.orderLowToHighMoney().subscribe(response => {
      this.listOfPeople = response;
    })
     }else{
      this.json = { "nationality" : this.nationalitySelected.nativeElement.value};
    this.service.findPersonByNationalityAndOrderLowToHighMoney(this.json).subscribe(response => {
      this.listOfPeople = response;
    })
    }
  }


  setOrderMoneyHighToLow(){
    if(this.nationalitySelected.nativeElement.value === "All"){
    this.service.orderHighToLowMoney().subscribe(response => {
      this.listOfPeople = response;
    })
     }else{
      this.json = { "nationality" : this.nationalitySelected.nativeElement.value};
      this.service.findPersonByNationalityAndOrderHighToLowMoney(this.json).subscribe(response => {
        this.listOfPeople = response;
      })
     }
  }


  setOrderAgeLowToHigh(){
    if(this.nationalitySelected.nativeElement.value === "All"){
    this.service.orderLowToHighAge().subscribe(response => {
      this.listOfPeople = response;
    })
    }else{
      this.json = { "nationality" : this.nationalitySelected.nativeElement.value};
      this.service.findPersonByNationalityAndOrderLowToHighAge(this.json).subscribe(response => {
        this.listOfPeople = response;
      })
    }
  }


  setOrderAgeHighToLow(){
    if(this.nationalitySelected.nativeElement.value === "All"){
      this.service.orderHighToLowAge().subscribe(response => {
        this.listOfPeople = response;
      })
    }else{
      this.json = { "nationality" : this.nationalitySelected.nativeElement.value};
      this.service.findPersonByNationalityAndOrderHighToLowAge(this.json).subscribe(response => {
        this.listOfPeople = response;
      })
    }    
  }

 
  onSelected(): void{
    if(this.nationalitySelected.nativeElement.value === "All"){
      console.log("PRIMERO")
        this.getList();
        this.search = true;
    }else{ 
        this.json = { "nationality" : this.nationalitySelected.nativeElement.value};    
        this.listOfPeople=[];
        this.service.findPersonByNationality(this.json).subscribe(response => {     
        this.listOfPeople = response;
    })    
  } 
}

  

  transferMoney(id: number){
    console.log(id);
    this.router.navigate(['toTransfer', {id: id}]);
    window.scrollTo(0, 0);
  }

  






}
