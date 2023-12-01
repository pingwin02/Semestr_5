import { Component, OnInit } from '@angular/core';
import { WarehouseService } from "../../service/warehouse.service";
import { ActivatedRoute, Router } from '@angular/router';
import { WarehouseForm } from "../../model/warehouse-form";

@Component({
  selector: 'app-warehouse-edit',
  templateUrl: './warehouse-edit.component.html',
  styleUrls: ['./warehouse-edit.component.css']
})
export class WarehouseEditComponent implements OnInit {

  constructor(
    private service: WarehouseService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  uuid: string | undefined;

  warehouse: WarehouseForm | undefined;

  original: WarehouseForm | undefined;


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getWarehouse(params['uuid']).subscribe((warehouse => {
        this.uuid = params['uuid'];
        this.warehouse = {
          name: warehouse.name,
          capacity: warehouse.capacity
        };
        this.original = {...this.warehouse};
      }));
    });
  }

  onSubmit(): void {
    this.service.updateWarehouse(this.uuid!, this.warehouse!).subscribe(() =>
      this.router.navigate(['/warehouses']));
  }

}
