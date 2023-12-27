import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ProductService } from "../../service/product.service";
import { ProductForm } from "../../model/product-form";


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  constructor(
    private service: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  name: string | undefined;

  weight: number | undefined;

  warehouseId: string | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.warehouseId = params['uuid'];
    });
  }

  onSubmit(): void {
    let product: ProductForm = {
      name: this.name!,
      weight: this.weight!,
      warehouseId: this.warehouseId!
    };

    this.service.createProduct(product).subscribe(() =>
      this.router.navigate(['/warehouse', this.warehouseId])
    );
  }
}
