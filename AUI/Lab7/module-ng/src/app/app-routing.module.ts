import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { WarehouseListComponent } from "./warehouse/view/warehouse-list/warehouse-list.component";
import { WarehouseViewComponent } from "./warehouse/view/warehouse-view/warehouse-view.component";
import { WarehouseEditComponent } from "./warehouse/view/warehouse-edit/warehouse-edit.component";
import { WarehouseCreateComponent } from "./warehouse/view/warehouse-create/warehouse-create.component";
import { ProductViewComponent } from "./product/view/product-view/product-view.component";
import { ProductEditComponent } from "./product/view/product-edit/product-edit.component";
import { ProductCreateComponent } from "./product/view/product-create/product-create.component";


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
  {
    component: ProductCreateComponent,
    path: "warehouses/:uuid/products/create",
  },
  {
    component: ProductViewComponent,
    path: "warehouses/:uuid/products/:id",
  },
  {
    component: ProductEditComponent,
    path: "warehouses/:uuid/products/:id/edit",
  },
  {
    path: "",
    redirectTo: "/warehouses",
    pathMatch: "full",
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
