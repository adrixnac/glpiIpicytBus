/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { ProductCatComponent } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.component';
import { ProductCatService } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.service';
import { ProductCat } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.model';

describe('Component Tests', () => {

    describe('ProductCat Management Component', () => {
        let comp: ProductCatComponent;
        let fixture: ComponentFixture<ProductCatComponent>;
        let service: ProductCatService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ProductCatComponent],
                providers: [
                    ProductCatService
                ]
            })
            .overrideTemplate(ProductCatComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ProductCatComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ProductCatService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new ProductCat(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.productCats[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
