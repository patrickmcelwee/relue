var GridTraverser = require('./grid_traverser.js')

describe('GridTraverser', function() {
  var traverser = new GridTraverser();

  it('works for 1x1 grid', function() {
    var result = traverser.countPathsThroughSquare(1);
    expect(result).toEqual(2);
  });
});
