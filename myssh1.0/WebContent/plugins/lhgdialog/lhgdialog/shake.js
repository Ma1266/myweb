$.dialog.fn.shake = function()
{
    var style = this.DOM.wrap[0].style,
        p = [4, 8, 4, 0, -4, -8, -4, 0],
        fx = function(){
            style.marginLeft = p.shift() + 'px';
            if(p.length <= 0){
                style.marginLeft = 0;
                clearInterval(timerId);
            }
        };
    p = p.concat(p.concat(p));
    timerId = setInterval(fx, 13);
    return this;
};