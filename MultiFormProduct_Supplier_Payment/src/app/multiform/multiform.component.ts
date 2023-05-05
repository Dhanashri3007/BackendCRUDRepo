import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HomeServiceService } from '../Service/home-service.service';

@Component({
  selector: 'app-multiform',
  templateUrl: './multiform.component.html',
  styleUrls: ['./multiform.component.css']
})
export class MultiformComponent {
  constructor(private fb: FormBuilder,private cs:HomeServiceService) { }
  product: FormGroup;
  width:number=0;
  background:string;
  ngOnInit() {
    
    this.product = this.fb.group({
      pid: [],
      pname: [],
      pprice: [],
      supplier: this.fb.group({
        sid: [],
        sname: [],
        contact: [],
        payment: this.fb.group({
          payid: [],
          bankName: [],
          ammount: []
        })
      })

    })

  }
  progressbar:string;
  step: number = 1;

  goToSecondForm() {
    this.step = this.step + 1;
    console.log(this.step);
   
    this.width=33.5;
     this.background="green";
    
  }

  goToThirdForm() {
    this.step = this.step + 1;
    console.log(this.step);
    
    this.width=this.width+33.5;
    
  }
  goBack() {
    this.step = this.step - 1;
    this.width=this.width-33.5;
  }
  save() {
     console.log(this.product.value);
    this.cs.postMultiFormData(this.product.value).subscribe();
    this.product.reset()
    this.width=this.width+33;
    window.location.reload();
  }
  
}
