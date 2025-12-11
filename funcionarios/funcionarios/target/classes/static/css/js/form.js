// form.js - controla exibição de campos específicos por cargo
document.addEventListener('DOMContentLoaded', function () {
  const cargo = document.getElementById('cargo');
  const gerente = document.getElementById('grupo-gerente');
  const dev = document.getElementById('grupo-desenvolvedor');
  const est = document.getElementById('grupo-estagiario');

  function atualizaCampos() {
    const val = cargo.value;
    gerente.style.display = val === 'Gerente' ? 'block' : 'none';
    dev.style.display = val === 'Desenvolvedor' ? 'block' : 'none';
    est.style.display = val === 'Estagiario' ? 'block' : 'none';
  }

  cargo && cargo.addEventListener('change', atualizaCampos);
  atualizaCampos(); // init
});
