import { Component } from '@angular/core';
import { WarehouseService } from "../../service/warehouse.service";
import { Router } from '@angular/router';
import { WarehouseForm } from "../../model/warehouse-form";

@Component({
  selector: 'app-warehouse-create',
  templateUrl: './warehouse-create.component.html',
  styleUrls: ['./warehouse-create.component.css']
})
export class WarehouseCreateComponent {

  constructor(
    private service: WarehouseService,
    private router: Router
  ) {
  }

  name: string | undefined;

  capacity: number | undefined;

  onSubmit(): void {
    let warehouse: WarehouseForm = {
      name: this.name!,
      capacity: this.capacity!
    };

    this.service.createWarehouse(warehouse).subscribe(() =>
      this.router.navigate(['/warehouses']));
  }

}
