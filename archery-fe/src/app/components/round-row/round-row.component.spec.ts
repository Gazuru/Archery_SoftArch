import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RoundRowComponent} from './round-row.component';

describe('RoundRowComponent', () => {
  let component: RoundRowComponent;
  let fixture: ComponentFixture<RoundRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RoundRowComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(RoundRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
