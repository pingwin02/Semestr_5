import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { WarehouseListComponent } from "./warehouse/view/warehouse-list/warehouse-list.component";
import { WarehouseViewComponent } from "./warehouse/view/warehouse-view/warehouse-view.component";
import { WarehouseEditComponent } from "./warehouse/view/warehouse-edit/warehouse-edit.component";
import { WarehouseCreateComponent } from "./warehouse/view/warehouse-create/warehouse-create.component";

const routes: Routes = [
  {
    component: WarehouseListComponent,
    path: "warehouses",
  },
  {
    component: WarehouseCreateComponent,
    path: "warehouses/create",
  },
  {
    component: WarehouseEditComponent,
    path: "warehouses/:uuid/edit",
  },
  {
    component: WarehouseViewComponent,
    path: "warehouses/:uuid",
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
