import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from "@angular/common/http";
import { AppComponent } from './app.component';
import { FormsModule } from "@angular/forms";
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { MainComponent } from './component/main/main.component';
import { NavComponent } from './component/nav/nav.component';
import { WarehouseViewComponent } from './warehouse/view/warehouse-view/warehouse-view.component';
import { WarehouseEditComponent } from './warehouse/view/warehouse-edit/warehouse-edit.component';
import { WarehouseCreateComponent } from './warehouse/view/warehouse-create/warehouse-create.component';
import { WarehouseListComponent } from './warehouse/view/warehouse-list/warehouse-list.component';

@NgModule({
  declarations: [
    AppComponent,
    WarehouseListComponent,
    FooterComponent,
    HeaderComponent,
    MainComponent,
    NavComponent,
    WarehouseViewComponent,
    WarehouseEditComponent,
    WarehouseCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
