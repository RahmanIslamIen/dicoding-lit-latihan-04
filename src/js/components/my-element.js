import { css, html, LitElement } from 'lit';

class MyElement extends LitElement {
  static properties = {};
  static styles = css`
    :host {
      display: block;
    }
  `;
  render() {
    return html`
      <p>
        <input type="color" />
      </p>
      <button>Terapkan</button>
      <button>Warna Acak</button>
    `;
  }
}

customElements.define('my-element', MyElement);
