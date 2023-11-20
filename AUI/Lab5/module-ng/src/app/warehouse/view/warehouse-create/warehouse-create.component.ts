import { Component, OnInit } from '@angular/core';
import { WarehouseService } from "../../service/warehouse.service";
import { Router } from '@angular/router';
import { WarehouseForm } from "../../model/warehouse-form";

@Component({
  selector: 'app-warehouse-create',
  templateUrl: './warehouse-create.component.html',
  styleUrls: ['./warehouse-create.component.css']
})
export class WarehouseCreateComponent implements OnInit {

  constructor(
    private service: WarehouseService,
    private router: Router
  ) {
  }

  warehouse: WarehouseForm | undefined;

  ngOnInit(): void {
    this.warehouse = {
      name: 'Warehouse name',
      capacity: 100
    };
  }

  onSubmit(): void {
    this.service.createWarehouse(this.warehouse!).subscribe(() =>
      this.router.navigate(['/warehouses']));
  }


}
