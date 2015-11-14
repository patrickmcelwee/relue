var GridTraverser = require('../lib/grid_traverser.js');

describe('GridTraverser', function() {
  var traverser = new GridTraverser();

  it('works for 1x1 grid', function() {
    var result = traverser.countPaths(1);
    expect(result).toEqual(2);
  });

  it('works for 2x2 grid', function() {
    var result = traverser.countPaths(2);
    expect(result).toEqual(6);
  });

  it('works for 3x3 grid', function() {
    var result = traverser.countPaths(3);
    expect(result).toEqual(20);
  });

  it('works for 4x4 grid', function() {
    var result = traverser.countPaths(4);
    expect(result).toEqual(70);
  });

  it('works for 20x20 grid', function() {
    var result = traverser.countPaths(20);
    expect(result).toEqual(137846528820);
  });

});
