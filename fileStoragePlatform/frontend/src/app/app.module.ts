// Angular
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// UI
import {
  AccordionModule,
  ButtonModule,
  CalendarModule,
  CheckboxModule,
  CodeHighlighterModule,
  ConfirmDialogModule,
  DataTableModule,
  DialogModule,
  FileUploadModule,
  GrowlModule,
  InputTextModule,
  ListboxModule,
  MultiSelectModule,
  PanelModule,
  RadioButtonModule,
  SharedModule,
  TabViewModule,
  ChartModule,
  TooltipModule,
  ConfirmDialog,
  BlockableUI,
  BlockUI,
  BlockUIModule
} from 'primeng/primeng';
import { MessageService } from 'primeng/components/common/messageservice';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


// Modules
import { NgPipesModule } from 'ng-pipes';

// Components
import { AppComponent } from './app.component';
import {
  HomeComponent,
  LoginComponent,
  MasterComponent,
  TableViewComponent,
  EntryDetailsComponent,
  ProfileComponent,
  UploadComponent,
  FilesComponent
} from 'app/components';

// Services
import {
  ApiService,
  AuthenticationService,
  AuthGuard,
  LocalStorageService,
} from 'app/service';
import { AppRoutingModule } from './app-routing.module';
import { RegisterComponent } from './components/pages/register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    EntryDetailsComponent,
    HomeComponent,
    LoginComponent,
    MasterComponent,
    ProfileComponent,
    RegisterComponent,
    TableViewComponent,
    UploadComponent,
    FilesComponent,
  ],
  imports: [
    AccordionModule,
    AppRoutingModule,
    BlockUIModule,
    BrowserAnimationsModule,
    BrowserModule,
    ButtonModule,
    CalendarModule,
    CheckboxModule,
    CodeHighlighterModule,
    ConfirmDialogModule,
    DataTableModule,
    DialogModule,
    FileUploadModule,
    FormsModule,
    FormsModule,
    GrowlModule,
    ChartModule,
    HttpModule,
    InputTextModule,
    ListboxModule,
    MultiSelectModule,
    NgPipesModule,
    PanelModule,
    RadioButtonModule,
    ReactiveFormsModule,
    SharedModule,
    TabViewModule,
    TooltipModule,
  ],
  providers: [
    ApiService,
    AuthenticationService,
    AuthGuard,
    LocalStorageService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
