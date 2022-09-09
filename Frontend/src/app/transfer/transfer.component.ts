import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../service/service.component';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  @ViewChild('receiver') receiverSelected!: ElementRef;
  
  private dataResponse: any;
  private listPersonAvailableToTransfer= [];
  private personAvailableToTransfer: any;
  private findAvailablePerson: boolean;
  private listToCompare = [];
  private json: object;
  private receiverPerson: number;

  constructor(private service: ServiceService, private router: Router,  private formBuilder: FormBuilder, private _route: ActivatedRoute) { }

  transferForm = this.formBuilder.group({
    senderName : '',
    senderLastname : '',
    senderMoneyAvailable : '',
    senderMoneyToTransfer : '',
    receiverDNI : '',
    receiverName : '',
    receiverLastname : ''
  })


  ngOnInit() {
    if(this.dataResponse == null){
      this.getPerson();
    }
    
    
  }


  getPerson(): void{
    this._route.params.subscribe((params) => {  
      this.service.getPersonById(params).subscribe((response) => {
        this.dataResponse = response;        

        this.transferForm.patchValue({
               senderName : this.dataResponse.name,
               senderLastname : this.dataResponse.lastname,
               senderMoneyAvailable : this.dataResponse.money
        })

        if(!this.findAvailablePerson){
          this.service.findPersonsAvailableToTransfer(params).subscribe((resp) => {
            this.listPersonAvailableToTransfer.push("---");
          this.personAvailableToTransfer = resp;
          this.personAvailableToTransfer.forEach((values) => {
               this.listPersonAvailableToTransfer.push(values.dni + ", " + values.lastname);
          })
        })
        this.findAvailablePerson = true;
      }                

      })


    })
  }


  
  onSubmit(){
    this.createJsonToRequest();
    this.service.moneyTransfer(this.json).subscribe((resp) => {
      console.log("Response to Transfer => " + resp);
    });

    this.router.navigate(['']);
  }



  onSelected(): void{      
      let dataReceiverPerson: any;

      this.personAvailableToTransfer.forEach((values) => {
          const saveReceiver = values.dni + ", " + values.lastname;

          if(saveReceiver === this.receiverSelected.nativeElement.value) this.receiverPerson = values.id;

      })


      this.service.getPersonById({"id" : this.receiverPerson}).subscribe((response) => {

        dataReceiverPerson = response;

        this.transferForm.patchValue({
          receiverDNI : dataReceiverPerson.dni,
          receiverName : dataReceiverPerson.name,
          receiverLastname : dataReceiverPerson.lastname
        })
      })

  }


  createJsonToRequest(): void{
    this.json =  {
      "sender": {
          "id" : this.dataResponse.id        
      },
      "receiver": {
          "id" : this.receiverPerson
      },
      "money" : this.transferForm.value.senderMoneyToTransfer
  }
  }


}
