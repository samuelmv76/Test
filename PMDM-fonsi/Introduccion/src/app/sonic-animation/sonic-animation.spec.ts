import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SonicAnimation } from './sonic-animation';

describe('SonicAnimation', () => {
  let component: SonicAnimation;
  let fixture: ComponentFixture<SonicAnimation>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SonicAnimation]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SonicAnimation);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
