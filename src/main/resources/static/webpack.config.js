module.exports = {
    entry: [
      './src/index.js'
    ],
    output: {
        path: __dirname + '/assets/',
        publicPath: "/assets/",
        filename: 'bundle.js'
    },
    module: {
        rules:[
        {
            test: /\.js$/, 
            loaders: ['jsx-loader?harmony','babel-loader?presets[]=react,presets[]=es2015'],
            exclude: /node_modules/
        },
        {
              test:/\.css$/,
              loaders: ['style-loader','css-loader']
          },
        {
              test: /\.less$/,
              loader: 'css?sourceMap&!postcss!less-loader?{"sourceMap":true,"modifyVars":{"@primary-color":"#008080"}}'
        },

           
          { 
            test: /\.(gif|jpg|png|woff|svg|eot|ttf)$/, 
            loader: 'url-loader?name=images/[hash:8].[name].[ext]'
          },
            { test: /\.html$/, 
              loader: "file-loader?name=[path][hash:8][name].[ext]!extract-loader!html-loader" }
          ]
         
    },
    
};