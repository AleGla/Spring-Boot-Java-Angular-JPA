import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ServiceService } from '../service/service.component';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  dataResponse:any;
  private json: object;
  constructor(private service: ServiceService, private router: Router,  private formBuilder: FormBuilder, private _route: ActivatedRoute) { }

  UpdateForm = this.formBuilder.group({
    DNI : '',
    name : '',
    lastname : '',
    age : '',
    nationality : '',
    address : '',
    streetnumber : '',
    money : ''
  })

       
  

  ngOnInit() {
    this.getPerson();
    
  }

  onSubmit(){
    this.createRequesJson();
      this.updatePerson();

      this.router.navigate(["toList"]);
  }

  updatePerson(){
    console.log("REQUEST-> ", this.json)
    this.service.updatePerson(this.json).subscribe(response => {
      console.log("response Update service", response);
    })
  }

  getPerson(){
    this._route.params.subscribe((params) => {
      this.service.getPersonById(params).subscribe(response => {
        console.log("Response By ID => " + response);
        this.dataResponse = response;                  
        
        this.UpdateForm.patchValue({
            DNI : this.dataResponse.dni,
            name : this.dataResponse.name,
            lastname : this.dataResponse.lastname,
            age : this.dataResponse.age,
            nationality : this.dataResponse.nationality,
            address : this.dataResponse.address,
            streetnumber : this.dataResponse.streetNumber,
            money : this.dataResponse.money
        })
      })
    })     
  }


  createRequesJson(): void{ 
   this.json = {
                  "id" : this.dataResponse.id,
                  "dni" : this.UpdateForm.value.DNI,
                  "name" : (this.UpdateForm.value.name).toUpperCase(),
                  "lastname" : (this.UpdateForm.value.lastname).toUpperCase(),
                  "age" : (this.UpdateForm.value.age).toString(),
                  "money" : this.UpdateForm.value.money,
                  "address" : (this.UpdateForm.value.address).toUpperCase(),
                  "streetNumber" : (this.UpdateForm.value.streetnumber).toString(),
                  "nationality" : (this.UpdateForm.value.nationality).toUpperCase()
             }
 
   }




}
