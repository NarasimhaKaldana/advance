import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  product: Product = new Product();
  constructor(private productService: ProductService,private router: Router){

  }

  ngOnInit(): void {
    
  }

  getProducts(){
    this.router.navigate(['/retrieve']);
  }
  

  saveProduct(){
    this.productService.saveProduct(this.product).subscribe(data=>{
      console.log(data);
      this.getProducts();
    },
    error=>console.log(error));
      
      
  }

  onSubmit(){
    this.saveProduct();
    console.log(this.product);
  }

}