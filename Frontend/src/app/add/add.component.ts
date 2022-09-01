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
    name : '',
    lastname : '',
    age : '',
    address : '',
    streetnumber : '',
    money : ''
  })

  ngOnInit() {

  }

  createRequesJson(){ 
   return   {
                 "name" : this.AddForm.value.name,
                 "lastname" : this.AddForm.value.lastname,
                 "age" : (this.AddForm.value.age).toString(),
                 "money" : this.AddForm.value.money,
                 "address" : this.AddForm.value.address,
                 "streetNumber" : (this.AddForm.value.streetnumber).toString()
            }

  }

onSubmit(){
  const  json = this.createRequesJson();
  this.addPerson(json);
  this.router.navigate(["toList"]);
  console.log("REWUEST =>" +  this.createRequesJson());
}


addPerson(obj: object){
  this.service.addPerson(obj).subscribe(response => {
      console.log(response)
  })
}


}
