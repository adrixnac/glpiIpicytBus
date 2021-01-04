/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { ProductCatDetailComponent } from '../../../../../../main/webapp/app/entities/product-cat/product-cat-detail.component';
import { ProductCatService } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.service';
import { ProductCat } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.model';

describe('Component Tests', () => {

    describe('ProductCat Management Detail Component', () => {
        let comp: ProductCatDetailComponent;
        let fixture: ComponentFixture<ProductCatDetailComponent>;
        let service: ProductCatService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ProductCatDetailComponent],
                providers: [
                    ProductCatService
                ]
            })
            .overrideTemplate(ProductCatDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ProductCatDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ProductCatService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new ProductCat(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.productCat).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
