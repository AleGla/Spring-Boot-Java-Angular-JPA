import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.component';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

   
  constructor(private service: ServiceService, private router: Router,  private formBuilder: FormBuilder) { }

  AddForm = this.formBuilder.group({
    dni : '',
    name : '',
    lastname : '',
    age : '',
    address : '',
    streetnumber : '',
    money : '',
    nationality : ''
  })

  ngOnInit() {

  }

  createRequesJson(){ 
   return   {
                 "dni" : this.AddForm.value.dni,
                 "name" : (this.AddForm.value.name).toUpperCase(),
                 "lastname" : (this.AddForm.value.lastname).toUpperCase(),
                 "age" : (this.AddForm.value.age).toString(),
                 "money" : this.AddForm.value.money,
                 "address" : (this.AddForm.value.address).toUpperCase(),
                 "streetNumber" : (this.AddForm.value.streetnumber).toString(),
                 "nationality" : (this.AddForm.value.nationality).toUpperCase()
            }

  }

onSubmit(){
  const  json = this.createRequesJson();
  this.addPerson(json);
  console.log("REWUEST =>" +  this.createRequesJson());
  this.router.navigate([""]); 
}


addPerson(obj: object){
  this.service.addPerson(obj).subscribe(response => {
      console.log(response)
  })
}


}
