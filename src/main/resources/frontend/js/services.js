application
    .factory('Element', function() {

        elements = [
            {id: '1', name:'Element 1', rank: '5', price: '15', demanded: '100', votes: '232',
                image: {
                    path: 'http://www.helensimages.com/bground/53.jpg'
                }
            },
            {id: '2', name:'Element 2', rank: '4', price: '20', demanded: '20',  votes: '45',
                image: {
                    path: 'http://www.helensimages.com/bground/ball.jpg'
                }
            },
            {id: '3', name:'Element 3',  rank: '3', price: '35', demanded: '300', votes: '107',
                image: {
                    path: 'http://www.helensimages.com/bground/z150.jpg'
                }
            }
        ];
        return {

            query: function() {
                return  elements;
            },
            get: function(id) {
                return elements[id-1];
            }
        }
    })
    .factory('Item', function() {
        items = [
            {id: '1', name:'Item 1', price: '5',    category: {id: '1', name: 'category1'}},
            {id: '2', name:'Item 2', price: '9',    category: {id: '2', name: 'category2'}},
            {id: '3', name:'Item 3', price: '3',    category: {id: '3', name: 'category3'}},
            {id: '4', name:'Item 4', price: '5.5',  category: {id: '1', name: 'category1'}},
            {id: '5', name:'Item 5', price: '6',    category: {id: '2', name: 'category2'}},
            {id: '6', name:'Item 6', price: '4',    category: {id: '2', name: 'category2'}}
        ];
        return {
            query: function() {
                return items;
            },
            get: function(id) {
                return items[id-1];
            }
        }
    })
    .factory('Category', function() {
        return {
            query: function() {
                return [
                    {id: '1', name: 'category1', open: 'true'},
                    {id: '2', name: 'category2', open: 'true'},
                    {id: '3', name: 'category3', open: 'true'}
                ];
            }
        }
    })
;